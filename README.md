# UUIA Java SDK
UUIA SDK in Java，一个向校园开发者提供快速适配 UUIA 框架并接入葫芦校园信息平台的校园信息聚合服务子节点服务端。

开发者仅需实现对应校园的各项服务数据的获取逻辑即可，无论其数据来源是官方授权接口或是自动爬虫。

此 SDK 的服务器基础基于 SpringBoot 框架。

## 参考快速接入步骤
1. 下载 / 克隆此项目。
2. 导入根目录 maven 项目。
3. 配置您在 UUIA 开放平台生成和获取的子节点 secret 和 App Key.
4. 根据 repository 中 含有 TODO 标记的类的指示，补全 数据获取逻辑 和 凭据存储逻辑 并返回填充好的指定数据类型。
5. 部署您的代码到外网可访问的生产环境，如需负载均衡可自行配置。
6. 到 UUIA 开放平台设置您的子节点入口 URL （若为分布式接口请填写服务发现入口URL）。
7. 到 UUIA 开放平台校验您的子节点有效性，校验成功后即接入完成。

若有任何疑问，请提出 issue 或直接与我们的开发者联系。

## SDK 异常处理
#### LackNecessaryInfoException

当您向中心服务器返回的数据类型缺少应填充的必要属性时，此异常将被抛出。

#### NotImplementedException

您还未实现此操作的数据获取逻辑时，此异常将被抛出。

## API规约
本脚手架项目实现了 UUIA API。您可以 [查看 UUIA API 规约文档](https://github.com/uuia/UUIA/blob/master/API.md)。

## 开源协定
本项目遵循 GPL-2.0 开源协议之规定。
