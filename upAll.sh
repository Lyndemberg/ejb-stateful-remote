sudo docker build -t dac-stateful/core ./dac-stateful-core
sudo docker run -p 8080:8080 -p 3700:3700 -d --name core dac-stateful/core
sudo docker build -t dac-stateful/jsf ./dac-stateful-jsf
sudo docker run -p 8081:8080 -d --name jsf --link core:host-core dac-stateful/jsf

