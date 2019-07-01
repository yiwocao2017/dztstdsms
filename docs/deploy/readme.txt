在装有java环境里
1，切换到DatGen.java目录,比如E目录
2，E:\>javac -d ./ DatGen.java
3，E:\>java DatGen '{"ipList":["127.0.0.1"],"codeList":["799001","799002","799003","799004","804030"]}'
4，拷贝当前目录下的“config.dat”到项目“{项目路径}\src\main\resources”
5，验证：项目跑起来。在浏览器输入“http://IP:端口/项目名/api”，出现版本信息即成功。



部署步骤：
1，将包导出到/home目录下，包上传至目录上。
  scp -P22 ./std-sms.war root@121.43.101.148:/home
  T6dh%$%$ss1
  
  scp -P57652 ./std-sms.war root@120.26.222.73:/home
  xnkj@151%
  
3，部署
  ssh root@121.43.101.148 -p 22
  
  cd /home/wwwroot/cdhome/tomcat_std_base/webapps
  cp ./std-sms/WEB-INF/classes/application.properties .
  cp ./std-sms/WEB-INF/classes/config.properties .
  
  rm -rf std-sms.war
  rm -rf std-sms
  mv /home/std-sms.war .
  
  mv -f application.properties ./std-sms/WEB-INF/classes/
  mv -f config.properties ./std-sms/WEB-INF/classes/
  
  ../bin/shutdown.sh
  ../bin/startup.sh
  
4,起停tomcat_develop_account

http://121.43.101.148:6207/std-sms/api

 --------------------push-sms
  cd /home/wwwroot/push-sms/tomcat_std_sms/webapps
  cp ./std-sms/WEB-INF/classes/application.properties .
  cp ./std-sms/WEB-INF/classes/config.properties .
  
  rm -rf std-sms.war
  rm -rf std-sms
  mv /home/std-sms.war .
  
  mv -f application.properties ./std-sms/WEB-INF/classes/
  mv -f config.properties ./std-sms/WEB-INF/classes/
  
  ../bin/shutdown.sh
  ../bin/startup.sh
  
  http://121.43.101.148:6502/std-sms/api


