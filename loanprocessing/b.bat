call ant -buildfile build/bootstrap.build -Dbypass.ivy=x
call ant -lib out/production/build -buildfile build/build.xml %* -Dbypass.ivy=x