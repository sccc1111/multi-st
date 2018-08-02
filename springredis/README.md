1.启动实例 redis.windows-service.conf
2.安装目录下复制【redis.windows-service.conf】文件重命名为【redis.windows-service6380.conf】。打开，修改其中的设置
  【port 6379】修改为【port 6380】
3.生成服务redis-server --service-install redis.windows-service6380.conf --service-name redis6380 --port 6380
