#! /bin/bash

#*****************************************************
# 项目重启shell脚本
# 先调用shutdown.sh停服
# 然后调用startup.sh启动服务
#
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
# 项目名称
APPLICATION=$(basename $BASE_PATH)

# 停服
echo stop ${APPLICATION} Application...
sh stop.sh

# 启动服务
echo start ${APPLICATION} Application...
sh start.sh
