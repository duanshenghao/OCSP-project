#! /bin/bash

#*****************************************************
# 先调用shutdown.sh停服
# author: fyh
# date: 2020/05/08
#*****************************************************

BIN_PATH=$(
  cd $(dirname $0)
  pwd
)
# 进入bin目录
cd $(dirname $0)
# 返回到上一级项目根目录路径
cd ..

BASE_PATH=$(pwd)
echo BASE_PATH is ${BASE_PATH} ...

# 项目名称
APPLICATION=$(basename $BASE_PATH)
echo APPLICATION is ${APPLICATION} ...

# 项目启动jar包名称
APPLICATION_JAR="${APPLICATION}.jar"
echo APPLICATION_JAR is ${APPLICATION_JAR} ...

PID=$(ps -ef | grep "${APPLICATION_JAR}" | grep -v grep | awk '{ print $2 }')
if [[ -z "$PID" ]]; then
  echo ${APPLICATION} is already stopped
else
  echo kill ${PID}
  kill ${PID}
  echo ${APPLICATION} stopped successfully
fi
