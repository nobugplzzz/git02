module.exports = {
  devServer: {
     port: 81,     // 端口号
    proxy: { //没有匹配到静态文件的请求) 代理到
      "/api": { //path: options 成对的对象,代理所有以‘/api’开头的请求
        target: "http://localhost:8081",
        changeOrigin: true, //将主机标头的来源更改为目标URL
        pathRewrite: {
          "^/api": "" //重写目标的url路径,去掉'/api'
        }
      }
    },
    disableHostCheck: true
  },
  chainWebpack: config => { //webpack 配置
    config.resolve.alias.set("@", resolve("src"));
  }
};

const path = require("path");
function resolve(dir) {
  return path.join(__dirname, dir);
}
