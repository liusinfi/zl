window.seajs&&seajs.config({
    // 别名配置
    alias: {
    },
    preload : [],
    // Sea.js 的基础路径
    //文件映射
    map: [
        //可配置版本号
        [ /^(.*\.(?:css|js|png|jpg|gif))(.*)$/i, '$1?v=2016102601' ]
    ]
});