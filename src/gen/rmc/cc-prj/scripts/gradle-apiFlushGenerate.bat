@echo off

call "%~dp0..\..\..\..\..\etc\setenv"

cd /d "%~dp0.."

gradle -p "%~dp0..\..\..\..\apis\cc-prj-api" -Dfile.encoding=UTF-8 apiMetadata
gradle -p "%~dp0..\..\..\..\boot\rmc" -Dfile.encoding=UTF-8 -PprojectName=cc -PapiJson=%~dp0..\..\..\..\apis\cc-prj-api\build\api.json -Ptarget=%~dp0.. apiFlushGenerate
