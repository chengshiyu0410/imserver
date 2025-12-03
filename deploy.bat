@echo off
echo [1/4] start  Native Image
call .\mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=imserver

echo [2/4] save as image  file
docker save -o imserver.tar imserver:latest

echo [3/4] upload imserver to server
scp imserver.tar root@8.154.25.252:/root/

echo [4/4] notify server to restart service
ssh root@8.154.25.252 "docker stop my-app || true && docker rm my-app || true && docker load -i imserver.tar && docker run -d -p 8080:8080 --name my-app imserver:latest"

echo [Done] deploy done
pause