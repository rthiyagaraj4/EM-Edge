<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@page import="org.jaxen.util.FollowingAxisIterator"%>
<%@page import="eCommon.XSSRequestWrapper,eBL.*"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patientid=request.getParameter("patientid");
	String facility_id=request.getParameter("facility_id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Financial Modification Authorization</title>

    <link rel='StyleSheet' href='../../eCommon/html/IeStyle_new.css' type='text/css'/>
    <script language='javascript' src='../../eCommon/js/jquery.js'></script>
    <script language='javascript' src='../../eBL/js/BLModifyFinancialDetails.js'></script>
    <style type="text/css">
        .authContainer {
            background-color: #F7F7F7;
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 5px; /* Add padding to the container */
            box-sizing: border-box; /* Ensure padding is included in the element's total width and height */
        }
        .auth-headercontainer {
            background-color: #00A0DD;
            width: 100%;
            max-width: 525px; /* Increased width by 5% */
            height: 110%; /* Increase height by 10% */
            border-radius: 3%;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 1%;
            margin-bottom: 1%;
            box-sizing: border-box; /* Ensure padding is included in the element's total width and height */
        }
        .auth-subcontainer {
            background-color: white;
            width: 100%;
            max-width: 525px; /* Increased width by 5% */
            border-radius: 2%;
            padding: 5px; /* Add padding inside the container */
            margin-bottom: .5rem; /* Add margin for spacing */
            box-sizing: border-box; /* Ensure padding is included in the element's total width and height */
        }
        .auth-title {
            text-align: left;
            font: normal normal bold 20px Segoe UI; /* Increased font size */
            color: white;
            margin: 2%;
            flex: 1;
            white-space: nowrap; /* Ensure text stays on one line */
        }
        .input-wrapper {
            margin-bottom: 0.2rem; /* Reduced margin for spacing */
        }
        .inputsmallContainer {
            display: flex;
            flex-direction: column;
        }
        .label-select {
            margin-bottom: 0.5rem;
        }
        .input {
            padding: 0.5rem; /* Add padding inside input box */
            margin-top: 0.5rem; /* Add margin above input box */
            box-sizing: border-box; /* Ensure padding is included in the element's total width and height */
        }
        .button_container {
            background-color: white;
            height: fit-content;
            display: flex;
            justify-content: flex-end;
            gap: 10px;
            width: 100%;
            max-width: 525px; /* Increased width by 5% */
        }
    </style>
	<script>
		window.onload = function() {
            const inputElement = document.getElementById('user_id');
            inputElement.addEventListener('keydown', makeUpperCase);
        };
		
		function makeUpperCase(event) {
            const inputElement = event.target;
            const char = String.fromCharCode(event.keyCode);

            // Check if the character is a lowercase letter
            if (char >= 'a' && char <= 'z') {
                const uppercaseChar = char.toUpperCase();
                
                // Prevent the default lowercase character from being inserted
                event.preventDefault();

                // Insert the uppercase character
                const start = inputElement.selectionStart;
                const end = inputElement.selectionEnd;
                inputElement.value = inputElement.value.substring(0, start) + uppercaseChar + inputElement.value.substring(end);

                // Move the cursor position
                inputElement.setSelectionRange(start + 1, start + 1);
            }
        }
	</script>
</head>
<body>
 <div class="authContainer">
    <div id="headerDiv" class="auth-headercontainer">
        <div class="auth-title">&nbsp;Financial Modification Authorization&nbsp;</div>
    </div>
    <div id="userid" class='auth-subcontainer'>
        <div class='input-wrapper inputsmallContainer'>
            <label class="label-select">User ID</label>
            <input type="text" class="input" id="user_id" autocomplete="off" autofocus onKeyPress='return makeUpperCase(event)' onblur="if(this.value != ''){validateUserId(this);}">
        </div>
    </div>
    <div id="password" class='auth-subcontainer'>
        <div class='input-wrapper inputsmallContainer'>
            <label class="label-select">Pin No.</label>
            <input type="password" class="input" id="passwrd" autocomplete="off" onblur="if(this.value != ''){validatePassword(this);}">
        </div>
    </div>
    <div id="remarks" class='auth-subcontainer'>
        <div class='input-wrapper inputsmallContainer'>
            <label class="label-select">Remarks</label>
            <input type="text" class="input" id="remark" autocomplete="off">
        </div>
    </div>
    <div class="button_container">
        <input type="button" class="btn btn-primary" value="OK" onclick="isValidUser();">
        <input type="button" class="btn btn-primary" value="Cancel" onClick="closeAuthPopup();">
    </div>
 </div>
 	<input type='hidden' id='patientid' value='<%=patientid%>'> 
 	<input type='hidden' id='facility_id' value='<%=facility_id%>'>
</body>
</html>