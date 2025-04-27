Attribute VB_Name = "ModMEDPrint"
Option Explicit
                        
Const FORMAT_MESSAGE_FROM_SYSTEM = &H1000
Global GArgArray(10)
   
Global Const GTestingYN = False
Global GVServerName As String
Global GVShareName As String
Global GVFunctionName As String
Global GVWorkingDir As String
Global GVCopies As Integer
Global GVReportType As String
Global GRetValStr As String
Global GVCmdLine As String

Public Const ERROR_INSUFFICIENT_BUFFER = 122
Public Const PRINTER_STATUS_BUSY = &H200
Public Const PRINTER_STATUS_DOOR_OPEN = &H400000
Public Const PRINTER_STATUS_ERROR = &H2
Public Const PRINTER_STATUS_INITIALIZING = &H8000
Public Const PRINTER_STATUS_IO_ACTIVE = &H100
Public Const PRINTER_STATUS_MANUAL_FEED = &H20
Public Const PRINTER_STATUS_NO_TONER = &H40000
Public Const PRINTER_STATUS_NOT_AVAILABLE = &H1000
Public Const PRINTER_STATUS_OFFLINE = &H80
Public Const PRINTER_STATUS_OUT_OF_MEMORY = &H200000
Public Const PRINTER_STATUS_OUTPUT_BIN_FULL = &H800
Public Const PRINTER_STATUS_PAGE_PUNT = &H80000
Public Const PRINTER_STATUS_PAPER_JAM = &H8
Public Const PRINTER_STATUS_PAPER_OUT = &H10
Public Const PRINTER_STATUS_PAPER_PROBLEM = &H40
Public Const PRINTER_STATUS_PAUSED = &H1
Public Const PRINTER_STATUS_PENDING_DELETION = &H4
Public Const PRINTER_STATUS_PRINTING = &H400
Public Const PRINTER_STATUS_PROCESSING = &H4000
Public Const PRINTER_STATUS_TONER_LOW = &H20000
Public Const PRINTER_STATUS_USER_INTERVENTION = &H100000
Public Const PRINTER_STATUS_WAITING = &H2000
Public Const PRINTER_STATUS_WARMING_UP = &H10000
Public Const JOB_STATUS_PAUSED = &H1
Public Const JOB_STATUS_ERROR = &H2
Public Const JOB_STATUS_DELETING = &H4
Public Const JOB_STATUS_SPOOLING = &H8
Public Const JOB_STATUS_PRINTING = &H10
Public Const JOB_STATUS_OFFLINE = &H20
Public Const JOB_STATUS_PAPEROUT = &H40
Public Const JOB_STATUS_PRINTED = &H80
Public Const JOB_STATUS_DELETED = &H100
Public Const JOB_STATUS_BLOCKED_DEVQ = &H200
Public Const JOB_STATUS_USER_INTERVENTION = &H400
Public Const JOB_STATUS_RESTART = &H800
 
Declare Function GetPrivateProfileString Lib "kernel32" Alias "GetPrivateProfileStringA" (ByVal lpApplicationName As String, ByVal lpKeyName As Any, ByVal lpDefault As String, ByVal lpReturnedString As String, ByVal nSize As Long, ByVal lpFileName As String) As Long
Declare Function GetProfileString Lib "kernel32" Alias "GetProfileStringA" (ByVal lpAppName As String, ByVal lpKeyName As String, ByVal lpDefault As String, ByVal lpReturnedString As String, ByVal nSize As Long) As Long

Declare Function WriteProfileString Lib "kernel32" _
Alias "WriteProfileStringA" _
(ByVal lpszSection As String, _
ByVal lpszKeyName As String, _
ByVal lpszString As String) As Long

Declare Function SendMessage Lib "user32" _
Alias "SendMessageA" _
(ByVal hwnd As Long, _
ByVal wMsg As Long, _
ByVal wParam As Long, _
lparam As String) As Long

Private Declare Function FormatMessage Lib "kernel32" Alias _
      "FormatMessageA" (ByVal dwFlags As Long, lpSource As Long, _
      ByVal dwMessageId As Long, ByVal dwLanguageId As Long, _
      ByVal lpBuffer As String, ByVal nSize As Long, Arguments As Any) _
      As Long


Public Declare Function OpenPrinter Lib "winspool.drv" _
   Alias "OpenPrinterA" _
   (ByVal pPrinterName As String, _
   phPrinter As Long, _
   pDefault As PRINTER_DEFAULTS) _
   As Long

Public Declare Function GetPrinter Lib "winspool.drv" Alias "GetPrinterA" _
   (ByVal hPrinter As Long, _
   ByVal Level As Long, _
   pPrinter As Byte, _
   ByVal cbBuf As Long, _
   pcbNeeded As Long) _
   As Long

Public Declare Function ClosePrinter Lib "winspool.drv" _
   (ByVal hPrinter As Long) _
   As Long

Public Declare Sub CopyMemory Lib "kernel32" Alias "RtlMoveMemory" _
   (Destination As Any, _
   Source As Any, _
   ByVal Length As Long)

Public Declare Function EnumJobs Lib "winspool.drv" Alias "EnumJobsA" _
   (ByVal hPrinter As Long, _
   ByVal FirstJob As Long, _
   ByVal NoJobs As Long, _
   ByVal Level As Long, _
   pJob As Byte, _
   ByVal cdBuf As Long, _
   pcbNeeded As Long, _
   pcReturned As Long) _
   As Long
   
' constants for PRINTER_DEFAULTS structure
Public Const PRINTER_ACCESS_USE = &H8
Public Const PRINTER_ACCESS_ADMINISTER = &H4

' constants for DEVMODE structure
Public Const CCHDEVICENAME = 32
Public Const CCHFORMNAME = 32

Public Type PRINTER_DEFAULTS
   pDatatype As String
   pDevMode As Long
   DesiredAccess As Long
End Type


Type SYSTEMTIME
   wYear As Integer
   wMonth As Integer
   wDayOfWeek As Integer
   wDay As Integer
   wHour As Integer
   wMinute As Integer
   wSecond As Integer
   wMilliseconds As Integer
End Type

Type JOB_INFO_2
   JobId As Long
   pPrinterName As Long
   pMachineName As Long
   pUserName As Long
   pDocument As Long
   pNotifyName As Long
   pDatatype As Long
   pPrintProcessor As Long
   pParameters As Long
   pDriverName As Long
   pDevMode As Long
   pStatus As Long
   pSecurityDescriptor As Long
   Status As Long
   Priority As Long
   Position As Long
   StartTime As Long
   UntilTime As Long
   TotalPages As Long
   Size As Long
   Submitted As SYSTEMTIME
   time As Long
   PagesPrinted As Long
End Type

Type PRINTER_INFO_2
   pServerName As Long
   pPrinterName As Long
   pShareName As Long
   pPortName As Long
   pDriverName As Long
   pComment As Long
   pLocation As Long
   pDevMode As Long
   pSepFile As Long
   pPrintProcessor As Long
   pDatatype As Long
   pParameters As Long
   pSecurityDescriptor As Long
   Attributes As Long
   Priority As Long
   DefaultPriority As Long
   StartTime As Long
   UntilTime As Long
   Status As Long
   cJobs As Long
   AveragePPM As Long
End Type


Public Function CheckPrinterStatus(PI2Status As Long) As String
   Dim tempStr As String
   Dim vbCrlf As String
   
   
   If PI2Status = 0 Then   ' Return "Ready"
      vbCrlf = ""
      CheckPrinterStatus = "Ready" & vbCrlf
   Else
      tempStr = ""   ' Clear
      If (PI2Status And PRINTER_STATUS_BUSY) Then
         tempStr = tempStr & "Busy "
      End If
      
      If (PI2Status And PRINTER_STATUS_DOOR_OPEN) Then
         tempStr = tempStr & "Printer Door Open "
      End If
      
      If (PI2Status And PRINTER_STATUS_ERROR) Then
         tempStr = tempStr & "Printer Error "
      End If
      
      If (PI2Status And PRINTER_STATUS_INITIALIZING) Then
         tempStr = tempStr & "Initializing "
      End If
      
      If (PI2Status And PRINTER_STATUS_IO_ACTIVE) Then
         tempStr = tempStr & "I/O Active "
      End If

      If (PI2Status And PRINTER_STATUS_MANUAL_FEED) Then
         tempStr = tempStr & "Manual Feed "
      End If
      
      If (PI2Status And PRINTER_STATUS_NO_TONER) Then
         tempStr = tempStr & "No Toner "
      End If
      
      If (PI2Status And PRINTER_STATUS_NOT_AVAILABLE) Then
         tempStr = tempStr & "Not Available "
      End If
      
      If (PI2Status And PRINTER_STATUS_OFFLINE) Then
         tempStr = tempStr & "Off Line "
      End If
      
      If (PI2Status And PRINTER_STATUS_OUT_OF_MEMORY) Then
         tempStr = tempStr & "Out of Memory "
      End If
      
      If (PI2Status And PRINTER_STATUS_OUTPUT_BIN_FULL) Then
         tempStr = tempStr & "Output Bin Full "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAGE_PUNT) Then
         tempStr = tempStr & "Page Punt "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAPER_JAM) Then
         tempStr = tempStr & "Paper Jam "
      End If

      If (PI2Status And PRINTER_STATUS_PAPER_OUT) Then
         tempStr = tempStr & "Paper Out "
      End If
      
      If (PI2Status And PRINTER_STATUS_OUTPUT_BIN_FULL) Then
         tempStr = tempStr & "Output Bin Full "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAPER_PROBLEM) Then
         tempStr = tempStr & "Page Problem "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAUSED) Then
         tempStr = tempStr & "Paused "
      End If

      If (PI2Status And PRINTER_STATUS_PENDING_DELETION) Then
         tempStr = tempStr & "Pending Deletion "
      End If
      
      If (PI2Status And PRINTER_STATUS_PRINTING) Then
         tempStr = tempStr & "Printing "
      End If
      
      If (PI2Status And PRINTER_STATUS_PROCESSING) Then
         tempStr = tempStr & "Processing "
      End If
      
      If (PI2Status And PRINTER_STATUS_TONER_LOW) Then
         tempStr = tempStr & "Toner Low "
      End If

      If (PI2Status And PRINTER_STATUS_USER_INTERVENTION) Then
         tempStr = tempStr & "User Intervention "
      End If
      
      If (PI2Status And PRINTER_STATUS_WAITING) Then
         tempStr = tempStr & "Waiting "
      End If
      
      If (PI2Status And PRINTER_STATUS_WARMING_UP) Then
         tempStr = tempStr & "Warming Up "
      End If
       
      'Did you find a known status?
      If Len(tempStr) = 0 Then
         tempStr = "Unknown Status of " & PI2Status
      End If
      
      'Return the Status
      CheckPrinterStatus = "Printer Status = " & tempStr & vbCrlf
   End If
End Function


Public Function GetString(ByVal PtrStr As Long) As String
   Dim StrBuff As String * 256
   
   'Check for zero address
   If PtrStr = 0 Then
      GetString = " "
      Exit Function
   End If
   
   'Copy data from PtrStr to buffer.
   CopyMemory ByVal StrBuff, ByVal PtrStr, 256
   
   'Strip any trailing nulls from string.
   GetString = StripNulls(StrBuff)
End Function

Public Function StripNulls(OriginalStr As String) As String
   'Strip any trailing nulls from input string.
   If (InStr(OriginalStr, Chr(0)) > 0) Then
      OriginalStr = Left(OriginalStr, InStr(OriginalStr, Chr(0)) - 1)
   End If

   'Return modified string.
   StripNulls = OriginalStr
End Function
Public Function MessageText(lCode As Long) As String
    Dim sRtrnCode As String
    Dim lRet As Long

    sRtrnCode = Space$(256)
    lRet = FormatMessage(FORMAT_MESSAGE_FROM_SYSTEM, 0&, lCode, 0&, _
              sRtrnCode, 256&, 0&)
    If lRet > 0 Then
       MessageText = Left(sRtrnCode, lRet)
    Else
       MessageText = "Error not found."
    End If

End Function
        
Public Sub GetCommandLine(Optional MaxArgs)
    Dim GVWorkingDir As String
    Dim LCMDFileName As String
    Dim CMDFSO As FileSystemObject
    Dim CMDFile As File
    
    'Declare variables.
   Dim C, CmdLnLen, InArg, I, NumArgs
   'See if MaxArgs was provided.
   If IsMissing(MaxArgs) Then MaxArgs = 10
   
   'Make array of the correct size.
   NumArgs = 0: InArg = False
   
   'Get command line from FunctionName.CMD
    GVWorkingDir = GetSysIni("Reports", "Dir")
    If Right(GVWorkingDir, 1) = "\" Then
        GVWorkingDir = Mid(GVWorkingDir, 1, Len(GVWorkingDir) - 1)
    End If
    LCMDFileName = GVWorkingDir & "\MEDPRINT.CMD"
    Close #3
    Open LCMDFileName For Input As 3
    Line Input #3, GVCmdLine
    Close #3
   
    CmdLnLen = Len(GVCmdLine)
   
   'Go thru command line one character
   'at a time.
   For I = 1 To CmdLnLen
      C = Mid(GVCmdLine, I, 1)
      'Test for ; (delimiter)
      If (C <> ";") Then
         If Not InArg Then
         'New argument begins.
         'Test for too many arguments.
            If NumArgs = MaxArgs Then Exit For
            NumArgs = NumArgs + 1
            InArg = True
         End If
         'Concatenate character to current argument.
         GArgArray(NumArgs) = GArgArray(NumArgs) & C
      Else
         'Found a space or tab.
         'Set InArg flag to False.
         InArg = False
      End If
   Next I
   
    'For I = 1 To NumArgs
    '    MsgBox GArgArray(I)
    'Next I
   
    '
    ' Remove CMD File.
    '
    'Set CMDFSO = New FileSystemObject
    'Set CMDFile = CMDFSO.GetFile(LCMDFileName)
    'CMDFile.Delete
   
End Sub
Function GetSysIni(section As String, key As String) As String
Dim retVal As String, AppName As String, worked As Integer
    retVal = String$(255, 0)
    worked = GetPrivateProfileString(section, key, "", retVal, Len(retVal), "MEDICOM.ini")
    If worked = 0 Then
        GetSysIni = "unknown"
    Else
        GetSysIni = Left(retVal, worked)
    End If
End Function

