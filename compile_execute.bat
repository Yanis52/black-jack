javac -Xlint:none -d build -cp lib/* @sources.txt
java -cp build;lib/* views.Home