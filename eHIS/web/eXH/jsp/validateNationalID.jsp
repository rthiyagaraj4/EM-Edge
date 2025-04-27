<!DOCTYPE html>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.*, eXH.*, webbeans.eCommon.ConnectionManager" %>
<%@ page import="java.sql.*,java.net.*, java.util.*" contentType="text/html;charset=UTF-8" %>

<HTML>	
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");   
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=11">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title> National Id </title>
	<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css"/>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="https://10.107.203.5:51341/v0/static/js/connector.min.js"></script>
	
    <script Language="JavaScript">

    <% 
    
    String nationalID=request.getParameter("nationalID");
    String sessionID=request.getParameter("sessionID");
    String facility=request.getParameter("facility");
    String loginUser=request.getParameter("loginUser");
    String p_ws_no=request.getParameter("p_ws_no");
    
    Connection conn = null;
    boolean isDebugYN = false;
    try {
        isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

        System.out.println("***Inside Validate National ID - isDebugYN Flag..." + isDebugYN);
        
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("***Inside Validate National ID - Exception while checking isDebugYN Flag... " + e);
    } finally {
        //ConnectionManager.returnConnection(conn); //V211020
        if (isDebugYN)
            System.out.println("***Inside Validate National ID - Conection closed");
    }
    
    String app_id ="";
    
    String sqlStatement = "";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
    	conn = ConnectionManager.getConnection();
        sqlStatement = "SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE SEGMENT_ID='MOHE1' AND ELEMENT_ID='APP_ID'";
        
        
        pstmt = conn.prepareStatement(sqlStatement);

        rs = pstmt.executeQuery();
        
        if (rs != null) {
            while (rs.next()) {
                app_id = rs.getString("DEFAULT_VALUE");
            }
        }

        if (isDebugYN)
            System.out.println("***Inside Validate National ID - SQL... " + sqlStatement + " ***app_id  : " + app_id);
    } catch (Exception e) {
        System.out.println("***Inside Validate National ID - Exception in fetching App_ID " + e);
    } finally {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        //ConnectionManager.returnConnection(conn);//V211020
        if (isDebugYN)
            System.out.println("***Inside Validate National ID - Conection closed");
    }
    
    %>
	
	$(document).ready(function() {   
     
	 /*$("#getNID").click(function() {		*/	
		if(<%=isDebugYN%>){
			alert("IE Version Support: "+document.documentMode);			
		}
		window.returnValue =  validateNationalID('<%=nationalID%>' ,'<%=sessionID%>', '<%=facility%>', '<%=loginUser%>', '<%=p_ws_no%>');
	    window.close();
		
	/*})*/
		
	});
	
	function validateNationalID(nationalID, sessionID, facility, loginUser, p_ws_no) {
	    var responseStr = '';
	    var resdata = '';
	    if(<%=isDebugYN%>){
	    	alert("Entering into the validateNationalID function");
	    }
	    if (nationalID == null || nationalID == "") {
	    	
	    	
	    	var appid = this.document.forms[0].app_id.value;
	    	
	    	if(<%=isDebugYN%>){
		    	alert("Initiating JSConnector by appId: "+appid);
		    }

	        JSConnector.init({
	            appID: appid
	        },function(data, error) {
	        	
	        	if(error){
	        		var errorJson = jQuery.parseJSON(error);
					if(<%=isDebugYN%>){
						alert("Init callback Error: "+errorJson);
					}
	        		$('.jsConnFailed').append('<h5 style="color:red"><p>JS Connector Initialization Failed. '+errorJson.error.message+'</p></h5>');
	        		return errorJson.error.message;
	        	}	        	
	        	
	        	resdata = jQuery.parseJSON(data);
	        	

	        	if(<%=isDebugYN%>){
			    	alert("JSConnector Initiated..."+resdata);
			    }

		        $('.jsConIni').append('<h5 style="color:green"><p>JS Connector Initialized Successfully...</p></h5>');
	        	
	        });
	        
	        
	        
	        JSConnector.authorizeCard({}, function(data, error) {
	             
	        	if(error){
	        		var errorJson = jQuery.parseJSON(error);
					if(<%=isDebugYN%>){
						alert("AuthorizeCard callback Error: "+errorJson);
					}
	        		$('.jsAuthFailed').append('<h5 style="color:red"><p>JS Connector Authorization Failed. '+errorJson.error.message+'</p></h5>');
	        		return errorJson.error.message;
	        	}
	             
				//var data = "{\"transactionRef\": \"\",\"requestID\": \"651c7936-f017-4210-be02-3603f6a00633\"}";
	            //alert('error:::' + error);
	            //alert('data:::' + data);
	            
	            resdata = jQuery.parseJSON(data);

	            $('.jsConAuth').append('<h5 style="color:green"><p>JS Connector Authorized Successfully with Operation UUID : '+resdata.operationUUID+'</p></h5>');
	            alert('resdata.operationUUID:::' + resdata.operationUUID);
	            $('.callingAPI').append('<h5 style="color:green"><p>Passing Operation UUID to Cysheild API</p></h5>');
	            responseStr = GetNationalID(nationalID, resdata, 1, sessionID, facility, loginUser, p_ws_no);
	            // return "S$!^TR455555555555$!^Retrived Successfully$!^Y$!^Y";
	            alert('responseStr (1):::' + responseStr);
	            
	        });


	    } else {
	    	$('.nidtoCyshAPI').append('<h5 style="color:green"><p>Passing national Id to Cysheild API with national Id :'+nationalID+'</p></h5>');
	        responseStr = GetNationalID(nationalID, resdata, 2, sessionID, facility, loginUser, p_ws_no);
	        // return "S$!^" + nationalID + "$!^Card is not issued$!^N$!^N";
	        alert('responseStr (2):::' + responseStr);
	    }
	    
	    return responseStr;

	}


	function GetNationalID(nationalID, resdata, apiType, sessionID, facility, loginUser, p_ws_no) {
	    var rtnResponse = "";
	    var request_type="";
	    
	    if(<%=isDebugYN%>){
	    	alert("Inside GetNationalID function... "+nationalID+":"+resdata+":"+apiType+":"+sessionID+":"+facility+":"+loginUser+":"+p_ws_no);
	    }
	    
	    request_type='MOHAD1';
	    
	    
	    $.ajax({
	        url: '../../servlet/eXH.InvokeEGLapplication',
	        type: 'POST',
	        cache: false,
	        data: {
	            callType: 'GetNationalID',
	            TRANS_REF_ID: resdata.operationUUID,
	            national_id: nationalID,
	            facility_id: facility,
	            logged_in_user: loginUser,
	            logged_in_ws_no: p_ws_no,
	            session_id: sessionID,
	            request_type:request_type
	        },
	        success: function(responseData) {
	        
	         	responseData = responseData.split("#");
	            responseData = responseData[0];
	            responseData = responseData.trim();
	            var resArray = responseData.split("$!^");
	            var response = resArray[0];
	            

	            if (response=="S" && resArray.length >= 10) {
	                if (apiType == 1) {
	                    rtnResponse = "S$!^"+resdata.operationUUID+"$!^" + resArray[8] + "$!^" + resArray[9];
	            		$('.cyshAPIResp').append('<h5 style="color:green"><p>Repsonse From Cyshiled API with National Id :'+resArray[8]+'</p></h5>');
	                } else {
	                    rtnResponse = "S$!^" +resArray[10]+ "$!^" + resArray[8] + "$!^" + resArray[9];
	        			$('.nidStatus').append('<h5 style="color:green"><p>Repsonse From Cyshiled API with National Id :'+resArray[8]+' and card issued status: ' + resArray[10] + '</p></h5>');
	                }
	            } else if (response=="F" && resArray.length >= 9) {
	            	var errorRes = jQuery.parseJSON(resArray[4]);
	                if (apiType == 1) {	                	
	                    rtnResponse = "F$!^"+resdata.operationUUID+"$!^" + resArray[8] + "$!^"+errorRes.statusDescription;
	                    $('.nidStatus').append('<h5 style="color:red">Failed to receive response from API<p></p></h5>');
	                } else {
	                    rtnResponse = "F$!^null$!^" + resArray[8] + "$!^"+errorRes.statusDescription;
	                    $('.nidStatus').append('<h5 style="color:red">Failed to receive response from API<p></p></h5>');
	                }
	            } else {
	                rtnResponse = "F$!^$!^Response Error (Length: " + resArray.length + ")$!^$!^";
	            }

	        },
	        dataType: 'text',
	        async: false
	    });

	    return rtnResponse;

	}
	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</HEAD>
<body>
	<form>
		<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%' height='150px'>
			<tr>
				<td width="100%" class="label">
					<p class='jsConIni text-success'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='jsConAuth text-success'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='callingAPI text-success'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='resAPI text-danger'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='cyshAPIResp text-success'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='nidtoCyshAPI text-success'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='nidStatus'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='jsConnFailed text-danger'></p>
				</td>
			</tr>
			<tr>
				<td width="100%" class="label">
					<p class='jsAuthFailed text-danger'></p>
				</td>
			</tr>
		</table>
		<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>
			<tr>
				<td><p id="demo" style="color:red;">Kindly wait... Fetching National ID... this window will close automatically...</p></td>
			</tr>
		</table>
		
		<input type="hidden" name="app_id" id="app_id" value='<%=app_id%>'>
	</form>
	
</body>
</HTML>

