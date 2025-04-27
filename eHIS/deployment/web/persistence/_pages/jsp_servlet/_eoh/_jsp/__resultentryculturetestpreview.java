package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOH.*;
import eOH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultentryculturetestpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/ResultEntryCultureTestPreview.jsp", 1709119368883L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    <TITLE>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TITLE>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/ResultEntry.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t<Style> </Style>\n</HEAD>\n<BODY OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=center>\n<TR> <TD class=fields>\n<TextArea Cols=\'115\' Name=\'result_text\' Rows=\'25\' readonly style=\"font-family:Courier new; \">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TextArea>\n</TD>\n</TR>\n<!-- <TR><td  class=\'button\'><INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'button\' onClick=\'window.close()\'></TD></TR> -->\n</Table>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );
	
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

int tempLength=0;
			int tempVertLength = 0;
			

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	String index	= request.getParameter("index");
	String chart_result_type	= request.getParameter("chart_result_type");
	if (index == null) index = "0";
	if (chart_result_type == null) chart_result_type = "";
	int colCount = 0;
	//ResultEntryBean bean = (ResultEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

    //HashMap parentMap 	=	bean.getCultureTestRecord();
	HashMap map			= new HashMap();
	HashMap descMap		= new HashMap();

	//if (parentMap != null && parentMap.containsKey(index))
		map = bean.getPreviewCultureTestRecord();

	//ArrayList organismDetails	= bean.getOrganismDetails();
	ArrayList antibioticValues	= bean.getAntibioticDetails(chart_result_type);

	//if (organismDetails == null) organismDetails = new ArrayList();
	if (antibioticValues == null) antibioticValues = new ArrayList();
	//out.println("<script>alert('"+antibioticValues.size()+"')</script>");
	StringBuffer previewText = new StringBuffer();
	//out.println("<script>alert('"+(map.containsKey("chart_no_columns"))+"')</script>");
	if (map.containsKey("chart_no_columns") && (!((String)map.get("chart_no_columns")).equals(""))) {

		colCount = Integer.parseInt((String)map.get("chart_no_columns"));
		
	}
    //out.println("<script>alert('"+(map.containsKey("remarks"))+"')</script>");
	if (map.containsKey("remarks") && (!((String)map.get("remarks")).equals(""))) {

		previewText.append("Remarks: " + (String)map.get("remarks") + "\n\n");
	}

	if (map.containsKey("antibiotic_organism_reqd_yn") && (((String)map.get("antibiotic_organism_reqd_yn")).equals("Y"))) {		

			previewText.append("\n"+(String)map.get("vertical_heading")+": ");//+"     \t"
			
			int count = 0;

			for(int i = 0; i < colCount; i++) {
				//out.println("<script>alert('"+(map.get("organism"+i))+"')</script>");
				if (!((map.containsKey("organism"+i)) && ((String)map.get("organism"+i)).equals(""))) {
					if (i % 3 == 0) {
						if (i != 0) {
							//previewText += "\n";

							for (int indx = 0; indx < (((String)map.get("horizontal_heading")).length() + 2); indx++) {
								previewText.append(" ");
							}
						}

					}
					String organismDesc = bean.getOrganismDesc((String)map.get("organism"+i),chart_result_type);
					//String tempOrganism	= (String)map.get("organism"+i);
					previewText.append(i+1 + "=" + organismDesc.trim() + " ,");
					count++;
				}

			}
			//previewText.append(previewText.substring(0,(previewText.length()-1)));
			String tempPreviewText="";
			tempPreviewText=previewText.toString();
			previewText.setLength(0);
			previewText.append(tempPreviewText.substring(0,(tempPreviewText.length()-1)));

			int maxLength = 0;
			

			String antibiotic_length 	= (String)map.get("antibiotic_length") ;
			int anti_length				= Integer.parseInt(antibiotic_length);

			for(int i = 0; i < anti_length; i++) {
				if (map.containsKey("antibiotic" + i)) {
					for (int j = 0; j < count; j++) {
						if (map.containsKey("result_type"+i)) {
							int tempMaxLength	= 0;
							
							if (((String)map.get("result_type"+i)).equals("L")) {
								tempMaxLength	= 12;//6
							} else if (((String)map.get("result_type"+i)).equals("N")) {
								tempMaxLength	= 17;
							} else if (((String)map.get("result_type"+i)).equals("D")) {
								tempMaxLength	= 12;
							} else if (((String)map.get("result_type"+i)).equals("E")) {
								tempMaxLength	= 18;
							} else if (((String)map.get("result_type"+i)).equals("T")) {
								tempMaxLength	= 7;
							} else if (((String)map.get("result_type"+i)).equals("C")) {
								tempMaxLength	= 3;
							}
							if (tempMaxLength > maxLength) {
								maxLength = tempMaxLength;
							}
						}
					}
				}
			}
		previewText.append("\n\n---------------------------");
			
			for (int i = 0; i < colCount; i++) {
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
				//previewText += "----------------";
			}
			//................................................Colum...................................
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block11Bytes, _wl_block11);

			int firstlable=((String)map.get("horizontal_heading")).length();			
						
			int tempAntBlenght=0;
			int largelable=0;
			int[] a=new int[anti_length];	   
			 for(int i = 0; i < anti_length; i++) {
			if (map.containsKey("antibiotic" + i)) {				
				String tempAntiBiotic = (String)map.get("antibiotic_desc" + i);
				 a[i]=tempAntiBiotic.length();	
				 tempAntBlenght=tempAntiBiotic.length();								
				}
			}	  
		 for (int i=0;i<a.length;i++){			 
			 if(a[i]>largelable)
			 {
			   largelable=a[i];
			}
		}		
		
		if(firstlable>largelable){				
				tempLength=2+firstlable+(firstlable-largelable);
				tempVertLength=1+firstlable;	
				//out.println("<script>alert('"+largelable+"')</script>");
				
		}
		
		else{
			tempVertLength=2+tempAntBlenght+(largelable-firstlable);
			tempLength=2+tempAntBlenght+(largelable-firstlable);
			//out.println("<script>alert('"+largelable+"')</script>");
			
		}
			

		//---------------------------
			previewText.append("\n"+(String)map.get("horizontal_heading")+"  ");
			//previewText += "\n"+(String)map.get("vertical_heading")+"     \t";
			//previewText += "\n"+(String)map.get("vertical_heading");//+"     \t"
			//int firstlable=((String)map.get("horizontal_heading")).length();
			
			//int tempVertLength = 16 - ((String)map.get("vertical_heading")).length();
			//if(firstlable<largeHeader)
			//	tempVertLength=tempVertLength-1;//+(tempAntBlenght-firstlable);
			//int tempVertLength = maxLength-((String)map.get("vertical_heading")).length();

			for (int i = 0; i < tempVertLength; i++) {
				previewText.append(" ");
			}
			//previewText.append("\t");

			for (int i = 0; i < count; i++) {
				previewText.append((i+1));
				int tempHeaderLength = maxLength - (Integer.toString(i+1)).length();
				for (int j = 0; j < tempHeaderLength; j++) {
				//	previewText += "";	
				}previewText.append("\t");
			}

			previewText.append("\n---------------------------");
			
			for (int i = 0; i < colCount; i++) {
				//previewText += "----------------";
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
			}
			previewText.append("\n");

			for(int i = 0; i < anti_length; i++) {
				if (map.containsKey("antibiotic" + i)) {
					//out.println("<script>alert('"+(((String)map.get("discr_msr_id"+i)))+"')</script>");
					String tempAntiBiotic = (String)map.get("antibiotic_desc" + i);

						//String [] record = (String[])antibioticValues.get(i);
					//if (record[1].equals(tempAntiBiotic))
					//	tempAntiBiotic			= record[0];
					
					//int tempLength = 16 - tempAntiBiotic.length();
					//int tempAntBlenght=tempAntiBiotic.length();					
					
					//int tempLength = 16 - tempAntiBiotic.length();
					//if(firstlable>tempAntBlenght)
						//tempLength=tempLength+(firstlable-tempAntBlenght);
					
					//int tempLength = maxLength - tempAntiBiotic.length();
					
					boolean continueFlag = false;

					for (int j = 0; j < count; j++) {						
						if (map.containsKey(i+""+j)) {
							if ( (((String)map.get(i+""+j))!=null && (!((String)map.get(i+""+j)).equals(""))) || ((String)map.get("discr_msr_id"+i)).equals("")) {
								continueFlag = true;
								break;
							}
						}
					}

					if (continueFlag) {
						if ( i != 0 && ((String)map.get("discr_msr_id"+i)).equals("")) {
							previewText.append("---------------------------");
							for (int indx = 0; indx < colCount; indx++) {							
								//previewText += "----------------";
								for (int j = 0; j < maxLength; j++) {
									previewText.append("-");
								}
							}
							previewText.append("\n");
						}


						previewText.append(tempAntiBiotic);
						
						for (int in = 0; in < tempLength; in++) {
						//for (int in = 0; in < 22; in++) {
							previewText.append(" ");
						}
						//previewText.append("\t");
						for (int j = 0; j < count; j++) {
							if (map.containsKey(i+""+j)) {
								tempAntiBiotic	= (String)map.get(i+""+j);
								//tempLength = maxLength - tempAntiBiotic.length();
								//tempLength = tempLength;
								previewText.append(tempAntiBiotic);

								if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("L")) {
									ArrayList resultTypeList = bean.getPreviewListResultTypeDetails((String)map.get("discr_msr_id"+i),tempAntiBiotic);
									
									if (resultTypeList != null && resultTypeList.size() > 0) {

										String [] strResultType		= (String[])resultTypeList.get(0);
										String antiBioticDesc		= strResultType[0];
										String antiDesc				= "";
										if(antiBioticDesc.length()>0)
											antiDesc				= antiBioticDesc.substring(0,1);
										if(antiDesc==null) antiDesc = "\t";

										previewText.append("("+antiDesc+")");
										descMap.put(tempAntiBiotic+antiDesc,antiBioticDesc);
									}
								} else if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("N")) {
									if ((!((String)map.get(i+""+j)).equals("")) && map.containsKey("num_uom"+i+""+j)) {
										previewText.append(" " + (String)map.get("num_uom"+i+""+j));
										//tempLength = maxLength - (tempAntiBiotic.length() + ((String)map.get("num_uom"+i+""+j)).length() + 1);
									}
								}
								for (int in = 0; in < tempLength; in++) {
									//previewText += "";
								}previewText.append("\t");
							}
						}

						previewText.append("\n");
						if (((String)map.get("discr_msr_id"+i)).equals("")) {
							previewText.append("---------------------------");
							for (int indx = 0; indx < colCount; indx++) {
								//previewText += "----------------";
								for (int j = 0; j < maxLength; j++) {
									previewText.append("-");
								}
							}
							previewText.append("\n");
							
						}
					}
				}
			}

			previewText.append("\n---------------------------");
			for (int i = 0; i < colCount; i++) {
				//previewText += "----------------";
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
			}
			if (descMap.size() > 0) {
				//for(int i = 0; i < anti_length; i++) {
				//	descMap		= beanObj.getPreviewListResultTypeDetails((String)map.get("discr_msr_id"+i),descMap);
				//}
				Set set			= descMap.keySet();
				Iterator itr	= set.iterator();
				previewText.append("\n");
				int breakCounter = 0;
				while(itr.hasNext()) {
					String key	= (String)itr.next();
					String key_code = "";
					if(key!=null && key.length()>0) {
						 key_code  = key.substring(key.length()-1);
						if(key_code==null) key_code = "";
					   previewText.append(key.substring(0,key.length()-1)  + "("+ key_code +")" + "="+ (String)descMap.get(key) + ";");
					}
					if (breakCounter == 3) previewText.append("\n");
					breakCounter++;
				}
				//previewText += "\nS=Sensitive; R=Resistant; I=Intermediate;\nMR=Mild Resistant; MS=Mild Sensitive;\n S1=S+; S2=S++; S3=S+++;";
				previewText.append("\n---------------------------");
				for (int i = 0; i < colCount; i++) {
					//previewText += "----------------";
					for (int j = 0; j < maxLength; j++) {
						previewText.append("-");
					}
				} 
			}
		}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(previewText));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		putObjectInBean(bean_id,bean,request);


            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Preview.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
