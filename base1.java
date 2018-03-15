项目组成结构：
dx.bat : 把所有.class 文件变成一个.dex文件
aapt : Android应用打包工具
adb : Android调试桥
doc : 目录存文档
source : 源码
plantform : 开发的平台
intel : 生成cpu 主要针对笔记本和PC机
arm : 生成标准

活动状态：
		运行--> 暂停--> 停止--> 销毁

活动的生存期：
	onCreate()  onState()  onResume()  onPause()  onStop()  onDestroy() onRestart() 

活动的四种启动模式：
		standard  singleTop  singleTask  singleInstance

standard : 在每次启动活动都会创建一个新的活动实例

singleTop ： 不管点击多少次，只要活动处于返回栈，栈顶就只有一个活动实例。

singleTask ：当启动该活动是时，如果发现已经存在则直接使用该实例，并把在这个活动之上的所有活动统统出栈

singleInstance ：指定这个模式的活动会启动一个新的返回栈来管理这个活动，
它和其他三个模式的不同之处是可以实其他程序和我们的程序可以共享这个活动的实例。

活动的启动模式可以在AndroidManifest.xml中通过给<activity>标签指定 android:launchMode 属性来选择启动模式
Android 四大组件：
		活动(Activity)、服务(Service)、广播接收器(Broadcast Receiver)、内容提供器(Content Provider)

所有活动在AndroidManifest.xml中进行注册才能生效。

Toast是Android 系统提供的一种非常友好的提醒方式，格式如下：

		Toast.makeText(context , "弹出的消息内容" , Toast.LENGYH_SHOUT).show();

当活动启动时就会执行onCreate()方法
protected void onCreate(Bundle saveInstanceState)

设置activity 的内容，内容来源于布局
setContentView(R.layout.cactivity_main);

安装包的生成路径：
build -- generated -- intermediates -- outputs -- apk -- debug -- xxx.apk 

