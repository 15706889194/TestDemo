@echo off
echo begin to generate db bean
java -jar libs\common-generator-0.0.33-20171201.101027-11.jar -configfile generatorConfig.xml -overwrite

echo end to generate db bean
