call runcrud.bat

if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo compilation failed
goto fail


:runbrowser
::call "C:\Program Files\Mozilla Firefox\firefox.exe" -new-tab "http://localhost:8080/crud/v1/task/tasks"
call "C:\Program Files\Mozilla Firefox\firefox.exe" -new-tab "http://localhost:8080/crud/v1/tasks"
echo Running browser...
goto end

:fail
echo.
echo There were errors with runcrud.bat

:end
echo.
echo Done.