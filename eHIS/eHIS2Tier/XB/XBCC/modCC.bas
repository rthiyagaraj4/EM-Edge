Attribute VB_Name = "modCC"
Global filelinecnt As Integer
'Connection string
Global gConnStr As String

'Adodb Connection(Oledb for Oracle)
Global gCnn As New ADODB.Connection
Global gSqlText As String

Global gCmd As New ADODB.Command

Global gTraceYn As String

'For Storing Response values
Global gRespCode As String
Global gRespTxt As String
Global gApprovalCode As String
Global gMercNmAdd As String
Global gTrnDate As String
Global gTrnTime As String
Global gApprovalCode1 As String
Global gInvNo As String
Global gTerminalIdNo As String
Global gMercNo As String
Global gCardIssNm As String
Global gCardIssBnk As String
Global gCardNo As String
Global gExpDt As String
Global gBatchNo As String
Global gRetrievalRefNo As String
Global gCardIssId As String
Global gCardHolderNm As String

Global gLRC As String

'For Storing Oracle Username, Password and Host passed. For Oracle Connection
Global gUsername As String
Global gPassword As String
Global gHost As String

'Msg Id, As one to one transaction
Global gMsgId As String

Global gWsno As String

Global gTmpStr As String

'for storing Trace Filename with the whole folderpath
Global gLogFileName As String

'Folder where logs are stored
Global gFolderpath As String

'For File writing (Trace logging)
Global fso As New FileSystemObject

Global gRequestText As String

Global gAmtStr As String
Global gAmt As Double
Global gInvoiceNo As String
Global gTrnType As String
Global gTermId As String
Global currentdt As Date

Global gRespMsg As String
Global gErrorText As String

Global GidleTime As Long
Global GidleTimeMs As Long

Global GrespFulltxt As String

Global GRespCalcLRC As String
Global GLRCValidFlag As String

' Check whether a given COM serial port is available

Public Function IsComPortAvailable(ByVal portNum As Integer) As Boolean
    Dim fnum As Integer
    On Error Resume Next
    fnum = FreeFile
    Open "COM" & CStr(portNum) For Binary Shared As #fnum
    
    If err = 0 Then
        Close #fnum
        IsComPortAvailable = True
        Kill "COM" & portNum
    End If
End Function

Public Sub WriteLog(pMsg As String)
    Dim tmpmsg As String
    
    filelinecnt = filelinecnt + 1
    
    If gTraceYn = "Y" Then
        If Not fso.FolderExists(gFolderpath) Then
            MkDir (gFolderpath)
        End If
        
        gLogFileName = gFolderpath & "\CC_" & Format(currentdt, "dd_Mmm_yy_hh_mm_ss_AMPM") & ".Log"
    
        '
        ' Open log file
        '
        
        If filelinecnt = 1 Then
            tmp_msg = "IBAeHIS Credit Card Interface Log"
            tmp_msg = tmp_msg + vbNewLine + "User Id : " + gUsername
            tmp_msg = tmp_msg + vbNewLine + "Created On : " + Format(Now, "dd/Mmm/yyyy hh:mm:ss AMPM")
            tmp_msg = tmp_msg + vbNewLine + "--------------------------------------------------------"
            tmp_msg = tmp_msg + vbNewLine + Format(Now, "dd/Mmm/yyyy hh:mm:ss AMPM") + "   " + pMsg
        Else
            tmp_msg = Format(Now, "dd/Mmm/yyyy hh:mm:ss AMPM") + "   " + pMsg
        End If
        
        Close #1
        Open gLogFileName For Append As 1
        Print #1, tmp_msg
    End If
End Sub
