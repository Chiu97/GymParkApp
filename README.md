移动应用开发2018
===============
### 组员：赵江宁 陈建秋 张峰玮 张袁峰
# 应用名称：GymParkApp
### Email: Madridchiu@gmail.com or 16301056@bjtu.edu.cn
## Assignment 1
![UI Dashboard](./GymParkAppImages/dashboard.png)
这是APP的UI Dashboard
这个主界面采用的是LinearLayout
一个组件分别为一个ImageView和三个Button
他们的Layout_weight都设置为1,所以比例都是一样大的
![Navigation Bar](./GymParkAppImages/navigation_bar.png)
这是APP的Navigation Bar
因为刚开始的时候我不了解NavigationBar,所以这是后面加的
问题就在于这个时候我已经把前面的主界面写好了,如果我想要把主界面加入NavigationBar的话有两个问题
第一个问题是我在主界面没有使用fragmentation,如果我点击navigation_bar中的选项的话切换的效果就很不好
第二个问题就是往写好activity加navigation_bar我想到的只有把activity嵌入一个新的drawer_layout,可那样未免有点麻烦
所以我干脆在专门写了一个测试navigation_bar的页面,虽然不实用,但是也算是一定程度上完成了任务吧
这个主要学习的是Android自己提供的Navigation Draw Activity,单击navigation bar中的sign out就可以登出账户,返回登录界面

## Assignment 2
![UI_Login](./GymParkAppImages/login_view.png)

这是主程序的登录界面
关于终端服务器,我采用的是[Bmob后端云](bmob.cn)进行验证
关于Bmob使用过程中记得是碰到了一个异常,去StackOverflow查看一些答案后发现要在manifest上一行android:usesCleartextTraffic="true"才能解决
Bmob的使用算是比较简单的,首先就是建立一个类继承BmobObject对应的是在Bmob中建好的数据库,然后就可以在Activity使用Bmob的查询插入等功能了
当用户登录时我们会把用户的用户名和密码发给Bmob,让Bmob从数据库中找有没有这个用户,有则重新登录,没有则提示用户名或者密码错误
一开始我在谷歌上看到的也是普通的PHP+mysql来解决的,但是我自己对PHP一无所知,经过尝试后发现确实太耗时了,所以还是采用了使用后端云的方案
![UI_Register](./GymParkAppImages/register_view.png)

这是注册的表格界面
我们会对用户输入的用户名是否为空,Email格式是否正确,两次输入的密码是否相同进行检查
验证邮箱格式的代码如下:
```Java
private boolean isValidEmail(CharSequence target) {
   return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
}
```
在确认用户输入的表格各项格式正确后,同样的,我们把数据发给Bmob,然后存进数据库.


