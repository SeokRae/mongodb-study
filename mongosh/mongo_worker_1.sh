### 도커 버전 확인
docker -v

# Docker version 20.10.8, build 3967b7d



### 몽고 DB 이미지 다운로드

docker pull mongo

## 도커 이미지 확인

docker images

## 도커 컨테이너 생성 및 실행

docker run --name mongodb-container -v ./data:/data/db -d -p 27017:27017 mongo
docker run --name mongodb -d -p 27017:27017 -v ~/docker/database/mongodb:/data/db mongo

## 도커 컨테이너 시작 / 중지 / 재시작do

docker stop mongodb-container

docker start mongodb-container

docker restart mongodb-container

## 도커 컨테이너 접속

docker exec -it mongodb-container bash

## 도커 로그 확인
docker logs mongodb-container

## 도커 볼륨 삭제

docker volume rm $(docker volume ls -qf dangling=true)
