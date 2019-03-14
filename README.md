# Customer Applications Argentina - Java Framework Zalenium 

## Instructions to be executed in Docker

### Prerequisite
* You must have installed docker (of course)
* You must have running zalenium grid in docker. 
  * `docker run -tid --restart always --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start` 
  * You have to check what is the zalenium grid url to put it into the step 4 
  * To search that `docker inspect zalenium | grep "IPAddress"`  
### Steps
1. Clone the project `git clone https://github.eagleview.com/pablo-spector/CAA_Automation_Java_Framework_Zalenium.git` 
2. Enter to root folder `cd CAA_Automation_Java_Framework_Zalenium` 
3. Build the app `docker build -t test_caa:latest .`
4. Run the app in AWS: `docker run -it --dns=10.0.2.3 --dns=10.112.97.17 --dns=10.112.97.16 --rm -e ZALENIUM_HOST=http://172.17.0.2:4444/wd/hub  test_caa:latest`
in Windows: `docker run -it --rm -e ZALENIUM_HOST=http://172.17.0.2:4444/wd/hub  test_caa:latest`
  
