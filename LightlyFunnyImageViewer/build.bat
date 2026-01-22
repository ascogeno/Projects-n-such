@echo off
set "SFML=D:\Libraries\SFML-3.0.2"

cl /EHsc /std:c++17 sprint.cpp /I "%SFML%\include" ^
 /link /LIBPATH:"%SFML%\lib" ^
 sfml-graphics.lib sfml-window.lib sfml-system.lib

pause
