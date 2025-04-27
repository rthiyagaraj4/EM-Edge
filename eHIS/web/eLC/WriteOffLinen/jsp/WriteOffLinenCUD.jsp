<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation"%>
<%@ page import="com.iba.ehis.core.vo.AppVO"%>
<%@ page import="java.util.Date"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%	
		String source=(String)request.getParameter("flag");
		String loggedInUser = (String) session.getAttribute("login_user");
		String function_id=(String)request.getParameter("function_id");
		String moduleId=(String)request.getParameter("moduleId");
		String facilityId=(String)session.getAttribute("facility_id");
		String locale = (String) session.getAttribute("LOCALE");
		//out.println("function_id="+function_id);
		//out.println("source="+source);
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
			
			UserPreferences userPrefs =new UserPreferences();
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
			String datepattrn=userPrefs.getDateFormat();
			String sb=userPrefs.getDateFormat();
			String tf=userPrefs.getTimeFormat();
			String pattern=sb+" "+tf;
			
			IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
			IBADateValidation ibadateVal = new IBADateValidation();
			String conDate = (String)ibadateVal.convertDateJS(todate.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		//	out.println("conDate="+conDate);

		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */ //AMRI-SCF-0679
									
		}catch(Exception e){} 
	
	//AMRI-SCF-0679
	String srcType = (String) session.getAttribute("sourceType");
	String srctype = (String) session.getAttribute("sourcetype");
	String src = (String) session.getAttribute("source");
	String srcCode = (String) session.getAttribute("sourceCode");
	//AMRI-SCF-0679
		/* String src=obj.getSource();
		String srcType=obj.getSourceType(); */
		request.setAttribute("srcType",srcType);
		request.setAttribute("src",src);
		//request.setAttribute("userFlag",userFlag);
		/* String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode(); */
	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
<script Language="JavaScript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/WriteOffLinen/js/WriteOffLinen.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/dwrlc/interface/WriteOffLinen.js"></Script>
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<Script Language="JavaScript" >
 function checkNumber1(val){
		  obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;
		if (!(alphaFilter.test(obj))) {
		getServerMessage("message.Numbers.Allowed");
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
		window.event.keyCode = 27;
		val.value="";
		}
			 
	}	 	


</Script>
</head>
	<body onload="CurrDate();disable1();getRefNumber();getUser();disableSource();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
          <ibaHTML:form action="/WriteOffLinenAction.do" target="messageFrame" >
		  <br>
			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
				<tr>
					<td CLASS='label' align="right"  >
						<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"
							bundle="lcLabels" />
						</td>
					<td class='label'>
						<ibaLogic:equal value="Laundry" scope="request" parameter="flag">  
						<ibaHTML:select property="vo.sourceType" onchange="disableSource();disable1();">
							<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.laundry" bundle="lcLabels" /></ibaHTML:option>
						</ibaHTML:select>
						</ibaLogic:equal>  
						<ibaLogic:equal value="" scope="request" parameter="flag">  
						<ibaHTML:select property="vo.sourceType" onchange="disableSource();disable1();">
						 <ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" /></ibaHTML:option>
						 <ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" /></ibaHTML:option>
						 <ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.laundry" bundle="lcLabels" /></ibaHTML:option>
						 <ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" /></ibaHTML:option>
						</ibaHTML:select>
						</ibaLogic:equal>  
						<img src="framework/images/mandatory.gif"></img>&nbsp&nbsp&nbsp&nbsp&nbsp	
						<ibaBean:message key="com.iba.ehis.lc.standardStock.source"
							bundle="lcLabels" />
						    <ibaHTML:text property="vo.source" size="20" maxlength="30" onblur="writeOffCommonLookup('source')"/>
							    <input type='hidden' name="vo.sourceCode" id="vo.sourceCode" value=''/>
								 <input type='button' id="lookup" name="lookup" id="lookup" class='button' value='?' onclick="showLookup('source');getExQty();" />
							<img id="srcImg" src="framework/images/mandatory.gif"></img>
						</td>
					<td>
					</td>
					<td>
					</td>
				  </tr>
				  <tr>
				  
				  <td CLASS='label' align='right' >
				    <ibaBean:message key="com.iba.ehis.lc.writeOffLinen.refNum" bundle="lcLabels" />
				  </td>
				 
				  <td CLASS='label'>
				    <ibaHTML:text property="vo.refNum" size="10" maxlength="10" readonly="true"/>
				    <img src="framework/images/mandatory.gif"></img>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				    <ibaBean:message key="com.iba.ehis.lc.date" bundle="lcLabels" />

					<input type=text name="date" id="date" value="<%=conDate%>" maxlength="15" readonly="true"/>
					<ibaHTML:hidden property="vo.date" value="<%=todate.toString()%>" />
					<!--  Modify by DhanasekarV for weblogic -->
					<ibaHTML:hidden property="vo.date.pattern" value="dd/MM/yyyy HH:mm" />

				    <img src='framework/images/mandatory.gif'></img>
			    </td>
				<td colspan=2></td>
				  
				</tr>  
				  
				<tr>
				
				<td CLASS='label' align='right' >
				   <ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels"/>
			    </td>
				  
				<td>
				  <ibaHTML:text property="vo.linenItem" onblur="if(this.value!='')showLookupLinen();" />
				  <input type='button' id="lookup" class='button' value='?' onclick="showLookupLinen();" />
				 <img src="framework/images/mandatory.gif"></img>
				 <ibaHTML:hidden property="vo.linenItemCode" value=''/>
			    </td>
				  
				<td>
			    </td>
				<td>
			    </td>
					
			    </tr>
				  
				<tr>
				<td CLASS='label' align='right' >
				   <ibaBean:message key="com.iba.ehis.lc.linenType" bundle="lcLabels" />
				</td>
				  
				<td>
			    	<ibaLogic:equal value="" scope="request" parameter="flag">  
						<ibaHTML:select property="vo.linenTypeCode" onchange="getExQty();">
				   		    <ibaHTML:option value="U"><ibaBean:message key="com.iba.ehis.lc.writeOffLinen.in-use"
							bundle="lcLabels"/></ibaHTML:option>
							<ibaHTML:option value="S"><ibaBean:message key="com.iba.ehis.lc.writeOffLinen.soiled"
							bundle="lcLabels" /></ibaHTML:option>
							<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.writeOffLinen.loaned"
							bundle="lcLabels" /></ibaHTML:option>
						</ibaHTML:select>
					</ibaLogic:equal>  
					<ibaLogic:equal value="Laundry" scope="request" parameter="flag">  
						<ibaHTML:select property="vo.linenTypeCode" onchange="getExQty();">
				   		    <ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.withLaundry"
							bundle="lcLabels"/></ibaHTML:option>
							<ibaHTML:option value="M"><ibaBean:message key="com.iba.ehis.lc.mending"
							bundle="lcLabels" /></ibaHTML:option>
							<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.inCleaning"
							bundle="lcLabels" /></ibaHTML:option>
						</ibaHTML:select>
					</ibaLogic:equal>  
					<img src="framework/images/mandatory.gif"></img>

				</td>
			    
			    <td>
				</td>
				
				<td>
				</td>
					
				</tr>
				 
			    <tr>
				 
				<td class='label' align='right' >
				   <ibaBean:message key="com.iba.ehis.lc.writeOffLinen.existingQty" bundle="lcLabels" />
				</td>
				
			    <td>
				 <ibaHTML:text property="vo.existingQty" size="4" maxlength="5" readonly="true"/>
				</td>
				 
				<td>
				</td>
				<td>
				</td>
					
			    </tr>
				 
				 <tr>
				 <td class='label' align='right' >
				   <ibaBean:message key="com.iba.ehis.lc.writeOffLinen.writeOffQty" bundle="lcLabels" />
				 </td>
				 
				 <td>
				   <ibaHTML:text property="vo.writeOffQty" size="4" maxlength="5" onblur="limit();" onkeypress="checkNumber1(this);" />
				   <img src="framework/images/mandatory.gif"></img>
				 </td>
				 
				 <td>
				 </td>
				 
				 <td>
				 </td>
					
				 </tr>
				 
				 <tr>
				  
				 <td class='label' align='right' >
				    <ibaBean:message key="com.iba.ehis.lc.writeOffLinen.reason" bundle="lcLabels" />
				 </td>
				  
				 <td>
				    <ibaHTML:text property="vo.reason" size="20" maxlength="100" onblur="writeOffCommonLookup('reason')"/>
				    <ibaHTML:hidden property="vo.reasonCode" />
				    <input type='button' id="lookup" class='button' value='?' onclick="showLookup('reason');" />
							<img src="framework/images/mandatory.gif"></img>
				 </td>
				 
				 <td>
				 </td>
				 <td>
				 </td>
					
				 </tr>
				  
				  <tr>
				  <td class='label' align='right'  >
				    <ibaBean:message key="com.iba.ehis.lc.writeOffLinen.remarks" bundle="lcLabels" />
				  </td>
				 
				 <td>
				    <ibaHTML:textarea property="vo.remarks" cols="50" rows="4" onkeyup="maxlength(this);"  onmouseout="maxlength(this);"></ibaHTML:textarea>
				 </td>
				 
				 <td>
				 </td>
				 
				 <td>
				</td>
					
				</tr>
				 
			   </table>
			   
			   <ibaHTML:hidden property="method" value="0" />
               <ibaHTML:hidden property="vo.functionId" value="<%=function_id%>"/>
			   <ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>"/>
			   <ibaHTML:hidden property="vo.locale" value="<%=locale%>"/>
			    <ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>"/>
  			   <input type="hidden" name="loggedInUser" id="loggedInUser" value="<%=loggedInUser%>"/>
   			   <input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>"/>
			   <input type="hidden" name="languageId" id="languageId" value="<%=locale%>"/>
			 
			
				<table align="center" ><tr><td>
			   <input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit' bundle='lcLabels' />" name="insert"  class="BUTTON" onclick="getRefNumber();submitData();"/></td></tr></table>
		  </ibaHTML:form>
	</body>
</ibaHTML:html>


