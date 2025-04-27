package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ambresequforvehicleamb extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AMBResEquForVehicleAMB.jsp", 1709113868115L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>Attached Resources For Vehicle</title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eAE/js/AMBResEquForVehicle.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</head>\n\t<body onscroll=\'scrollTitleTop()\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name = \'secForNoteTypeSectionsForm\' action=\'../../servlet/eAE.AMBEquipmentForVehicleServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<th align=\'center\' colspan=\'5\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<th align=\'center\' width = \'30%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\t\t\n\t\t\t\t\t<th align=\'center\' width = \'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\t\n\t\t\t\t\t<th align=\'center\' width =\'15%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t\t\t\t\t\n\t\t\t\t\t<th align=\'center\' width =\'15%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th align=\'center\' width =\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'note_type\' id=\'note_type\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'conc_string\' id=\'conc_string\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'countOfRows\' id=\'countOfRows\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'firstPos\' id=\'firstPos\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'secPos\' id=\'secPos\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\"true\">\n\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\t\t\t<input type=\'hidden\' name=\'amb_equ_type\' id=\'amb_equ_type\' value=\'RS\'>\n\t\t</form>\n\t\t<script>\n\t\t\tparent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.search.disabled = true;\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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

	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//	out.println("request==>"+request.getQueryString());
		    String facilityId 	= (String) session.getValue( "facility_id" ) ;
			String mode					= request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag_for_list		= request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows				= request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition		= request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition		= request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			String strResource			= request.getParameter("currResource") == null ? "" : request.getParameter("currResource");
			String strPosition			= request.getParameter("posDesc") == null ? "" : request.getParameter("posDesc");
			String strPosDisplay		=	"";
			String strResType			=	"";
			String rowID				=	"";

			if(strPosition.equals("") || strPosition.equals("AA") )
			{
				strPosition		= "AA";
				strPosDisplay	=	"&nbsp;";
			}
			else
				strPosDisplay	=	strPosition;
				
			String chief_complaint_sec_type = "F";
			int cnt = 0;
			String chk="";
			String disable="";
			//boolean flag=true;
			int count=0;
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					if(!mode.equals("modify"))
					{
						Connection con						= null;
						PreparedStatement pstmtNoteSections = null;
						ResultSet resNoteSections			= null;
						
						String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

						String sec_heading_code = "";
						String sec_heading_desc = "";
						String chief_complaint_sec_yn = "";
						String sqlNoteSec = "";
						String mapValue = "";
						int srlNo = 1;

						try
						{
							con = ConnectionManager.getConnection(request);
							
							sqlNoteSec = "SELECT b.AMB_VEHICLE_NAME note_type_desc,c.PRACT_SOURCE, a.AMB_RESOURCE_ID AMB_RESOURCE_ID, c.PRACTITIONER_NAME PRACTITIONER_NAME, CONTACT_DISPLY_YN,DECODE(A.AMB_RESOURCE_TYPE,'P','Practitioner','E','External Practitioner','O','Other Staff') RESTYPE,NVL(C.POSITION_DESC,'AA') POSITION_dESC,A.AMB_RESOURCE_ID || '~' || c.PRACT_SOURCE ROWIDEN  FROM AE_AMB_VEHICLE_RESOURCE a, AE_AMB_VEHICLE b, AM_PRACT_FOR_AMB_VW c where a.AMB_VEHICLE_ID = b.AMB_VEHICLE_ID AND a.facility_id = b.facility_id and a.AMB_RESOURCE_ID = c.PRACTITIONER_ID and a.AMB_RESOURCE_TYPE = c.PRACT_SOURCE and a.AMB_VEHICLE_ID = ? and b.facility_id = '"+facilityId+"'  ";

							System.err.println("AMBResEquForVehicleAMB.jsp sqlNoteSec===>"+sqlNoteSec);
							System.err.println("AMBResEquForVehicleAMB.jsp note_type===>"+note_type);
							
							pstmtNoteSections = con.prepareStatement(sqlNoteSec);

							pstmtNoteSections.setString(1,note_type);
							resNoteSections = pstmtNoteSections.executeQuery();
					
							while(resNoteSections.next())
							{
								rowID			  =	resNoteSections.getString("ROWIDEN");
								sec_heading_code = resNoteSections.getString("AMB_RESOURCE_ID");
								sec_heading_desc = resNoteSections.getString("PRACTITIONER_NAME");

								chief_complaint_sec_yn = resNoteSections.getString("CONTACT_DISPLY_YN");
								strResource		=	resNoteSections.getString("RESTYPE");
								strPosition		=	resNoteSections.getString("POSITION_DESC");
								strResType		= resNoteSections.getString("PRACT_SOURCE");
								if(strPosition == null || strPosition.equals("AA") )
									strPosDisplay  = "&nbsp;";
								else
									strPosDisplay  = strPosition;

								if(chief_complaint_sec_yn.equals("Y"))
								{
								  	chk="checked";
									count++;
								}
								else
									chk="";	

								if(cnt%2 == 0)
									classValue = "QRYEVEN";
								else
									classValue = "QRYODD";

								out.println("<tr id = 'numRows"+cnt+"'>");
								out.println("<td style='display:none'> <input type = 'hidden' value = '"+sec_heading_code+"' name = 'sec_heading_code"+cnt+"'> </td>");						
								out.println("<td style='display:none'> <input type='hidden' value = '"+chief_complaint_sec_yn+"' name='chief_complaint_yn"+cnt+"' id='chief_complaint_yn"+cnt+"'> </td>");
								out.println("<td style='display:none'> <input type='hidden' value = '"+strResource+"' name='resource"+cnt+"' id='resource"+cnt+"'> </td>");
								out.println("<td style='display:none'> <input type='hidden' value = '"+strPosition+"' name='position"+cnt+"' id='position"+cnt+"'> </td>");
								out.println("<td style='display:none'> <input type='hidden' value = '"+strResType+"' name='resType"+cnt+"' id='resType"+cnt+"'> </td>");
//								out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+cnt+"','"+srlNo+"')\"> "+srlNo+" </a></td>");
								out.println("<td class='"+classValue+"'> "+sec_heading_desc+" </td>");
								out.println("<td class='"+classValue+"'> "+strPosDisplay+" </td>");
								out.println("<td class='"+classValue+"'> "+strResource+" </td>");
								out.println("<td class='"+classValue+"' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");							
								out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+cnt+"' id='chief_complaint"+cnt+"'"+disable+"   value='"+chief_complaint_sec_yn+"' "+chk+"						onclick=`addRecord(this,\""+rowID+"\",\""+sec_heading_desc+"\",\""+srlNo+"\",\""+cnt+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");
								out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' checked onclick='removeRecord(this,\""+rowID+"\",\""+cnt+"\",\""+strResource+"\",\""+strPosition+"\")'> </td>");
								out.println("</tr>");							
								//out.println("chief_complaint_sec_yn"+chief_complaint_sec_yn);
								
								sec_heading_desc	= sec_heading_desc.replace("~","$$$");


								mapValue = sec_heading_desc + "~" + srlNo + "~" + chief_complaint_sec_type+ "~" + chief_complaint_sec_yn+"~"+strResource +  "~"+strPosition;


								resequBean.addRecords(rowID,mapValue);
								resequBean.addToList(cnt,rowID);
								cnt++;
								srlNo++;
							}
							
							out.println("<tr style='display:none' id='extraRow'><td align=\"center\" id='extraTD'><a href=\"javaScript:changeColor('"+cnt+"','"+srlNo+"')\">"+srlNo+"</td><td></td><td ></td></tr>");
							putObjectInBean("resequBean",resequBean,session);


							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();
						}
						catch(Exception e)
						{
							//out.println("Exception "+e.toString());
							e.printStackTrace(System.err);
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
				String chief_complaint = "";
				String heading_seq_num = "";
				String heading_desc = "";
				//StringTokenizer strCodeToken = null;
				String chief_complaint_sect_yn="";
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
					String check="";
					if(!flag_for_list.equals("false"))
					{
						
						if(totalRows < positionTwo)
							positionTwo = positionTwo -1;
						else
							positionTwo = positionTwo;

						int k = 0;
						ArrayList list = resequBean.retrieveArrayList();
						
						for(k=0;k<list.size();k++)
						{
							codeList = (String) list.get(k);
							if(positionOne == k)
							{
								resequBean.addToList(positionTwo,codeList);
								if(positionTwo > positionOne)
								{
									k = list.size();
								}
							}						
						}
						if(positionTwo > positionOne)
						{
							resequBean.removeElement(positionOne);
						}
						else
						{
							resequBean.removeElement(positionOne+1);
						}
						putObjectInBean("resequBean",resequBean,session);
					}
					
					
					HashMap recValues = resequBean.getHashValues();
					ArrayList indexList = new ArrayList();
					indexList = resequBean.retrieveArrayList();
					for(i=0; i<indexList.size(); i++)
					{
						tempInt = i +1;
					


						keyVal = (String)indexList.get(i);
						mapVal = (String)recValues.get(keyVal);
		
						StringTokenizer strCodeToken = new StringTokenizer(mapVal,"~");
						//out.println("239keyVal "+i+"==>"+keyVal);
						//out.println("240mapVal"+i+"==>"+mapVal);
						while(strCodeToken.hasMoreTokens())
						{
							//out.println("strCodeToken==>"+strCodeToken);
							
							heading_desc = strCodeToken.nextToken();
							heading_desc=heading_desc.replace("$$$","~");

							heading_seq_num = strCodeToken.nextToken();
							chief_complaint = strCodeToken.nextToken();
							chief_complaint_sect_yn=strCodeToken.nextToken();
							strResource		=	strCodeToken.nextToken();
							strPosition		=   strCodeToken.nextToken();
									
								if(strPosition == null || strPosition.equals("") || strPosition.equals("AA") )
									strPosDisplay  = "&nbsp;";
								else
									strPosDisplay  = strPosition;

							if(strResource.equals("Practitioner") )
								strResType	=	"P";
							else if(strResource.equals("External Practitioner") )
								strResType	=	"E";
							else
								strResType	=	"O";


//							if(chief_complaint.equals("Y")||chief_complaint.equals("T")||chief_complaint.equals("S"))//**
  //                          {
								//check="";
								
//								disable="disabled";
//							}
//							else 
  //                          {
								//check="";
								disable="";
	//						}
							if(chief_complaint_sect_yn.equals("Y"))

							{
								if(chief_complaint.equals("Y")||chief_complaint.equals("T")||chief_complaint.equals("S"))//**
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
								check="";
							

							if(heading_seq_num.equals(" "))
								heading_seq_num = "";
							else
								heading_seq_num = heading_seq_num;

							if(i%2 ==0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";
							out.println("<tr id = 'numRows"+i+"'>");
							out.println("<td style='display:none'> <input type= hidden value='"+keyVal+"' name='sec_heading_code"+i+"' id='sec_heading_code"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value='"+chief_complaint+"' name='chief_complaint_yn"+i+"' id='chief_complaint_yn"+i+"' </td>");
							out.println("<td style='display:none'> <input type='hidden' value = '"+strResource+"' name='resource"+i+"' id='resource"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value = '"+strPosition+"' name='position"+i+"' id='position"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value = '"+strResType+"' name='resType"+i+"' id='resType"+i+"'> </td>");

//							out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+i+"','"+tempInt+"')\"> "+tempInt+" </a></td>");
							out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
							out.println("<td class='"+classValue+"' > "+strPosDisplay+" </td>");
							out.println("<td class='"+classValue+"'> "+strResource+" </td>");
							out.println("<td class='"+classValue+"' align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
							//out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=\"addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")\"> </td>");


							out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+" 						onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");

							//out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");

							out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' checked onclick='removeRecord(this,\""+keyVal+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")'> </td>");
							out.println("</tr>");	
							

						check="";								
						}
					}
					tempInt++;
					out.println("<tr style='display:none' id='extraRow'><td align=\"center\"><a href=\"javaScript:changeColor('"+i+"','"+tempInt+"')\">"+tempInt+"</td><td></td><td></td></tr>");
					cnt = indexList.size();
				}
				catch(Exception e)
				{
					//out.println("Exception " +e.toString());
					e.printStackTrace(System.err);
				}
			}
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AssociatedStaff.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisplayContact.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
}
