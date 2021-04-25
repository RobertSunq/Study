# vue-notes



## 基本语法



#### 语法示例

```html
<!--数据绑定最常见的形式就是使用 {{...}}（双大括号）的文本插值：-->
<div id="vue_det">
    <h1>site : {{site}}</h1>
    <h1>url : {{url}}</h1>
    <h1>{{details()}}</h1>
</div>
```



```javascript
<script type="text/javasccript">
    var data = { site: "基础教程", url: "www.baidu.com", alexa: 10000}
//Vue应用需要实例化VUE实现
  var vm = new Vue({
  // 选项
      el："vue_det",  // 绑定DOM元素中的id
      data:data // 用于定义属性
      methods:{function:""} //用于定义函数，也可以通过return来返回函数值在重新渲染的时候，函数总会重新调用执行
      computed:    // 计算属性  基于它的依赖缓存，只有相关依赖发生改变时才会重新取值  
                   //依托已有的字段计算得来 
                   //必须有返回值 
                   //与数据字段的使用方式一样 
                   //具有缓存的效果
                   // 默认只有 getter ，不过在需要时你也可以提供一个 setter 
       watch:	   // 监听属性
      components:{	// 局部组件  只在父模板中可用
                  // props: // 父组件的数据需要通过 props 把数据传给子组件，子组件需要显式地用 props 选项声明 "prop"
                   
                   }  
})
  
  

// Vue实例还提供了一些有用的实力属性与方法，使用的是前缀  $  用于与用户定义的属性进行区分
document.write(vm.$data === data) // true
document.write("<br>") 
document.write(vm.$el === document.getElementById('vue_det')) // true



//  指令： 
//       带有v-前缀的特殊属性，指令用于在表达式的值改变时，将某些行为应用到DOM上
// eg:  v-if:"true/false"   	// 决定是否插入元素
//            v-if、v-else、v-else-if 
//      v-bind:          		// 用来响应的更新HTML属性//缩写为：":"
		//  在vue中处理class和style时，也是使用v-bind。
//      v-on:click="doSthing"	//用于监听DOM事件 //缩写为："@"
//      v-model:				//用来在input、select、textarea、checkbox、radio等表单控件元素上创建双向数据绑定，根据表单上的值，自动更新绑定的元素的值。
//      v-show:                 //根据条件展示元素
//      v-for:"item in items"				    //循环指令



//  修饰符：
//        以半角句号"."指明的特殊后缀，用于支出一个指令应该以特殊方式绑定
//  eg： .prevent 修饰符告诉 v-on 指令对于触发的事件调用 event.preventDefault()
//		 .lazy  v-model 在 input 事件中同步输入框的值与数据  修饰符 lazy ，从而转变为在 change 事件中同步     v-model.lazy=
//       .number 自动将用户的输入值转为 Number 类型     v-model.number= 
//		 .trim  自动过滤用户输入的首尾空格       v-model.trim=


//  过滤器： 
//        过滤器函数接受表达式的值作为第一个参数
//        <!-- 在两个大括号中 -->
//        {{ message | capitalize }}

//		  <!-- 在 v-bind 指令中 -->
//        <div v-bind:id="rawId | formatId"></div>


//  路由：
//		<router-link> 是一个组件，该组件用于设置一个导航链接
//						to 属性为目标地址  <router-link to="/foo">
//						replace 点击调用router.replace() 导航后不留下history
//						append 当前 (相对) 路径前添加其路径

//  事件修饰符：
			// .stop - 阻止冒泡
			// .prevent - 阻止默认事件
			// .capture - 阻止捕获
			// .self - 只监听触发该元素的事件
			// .once - 只触发一次
			// .left - 左键事件
			// .right - 右键事件
			// .middle - 中间滚轮事件

			/* 	<!-- 阻止单击事件冒泡 -->
				<a v-on:click.stop="doThis"></a>
				<!-- 提交事件不再重载页面 -->
				<form v-on:submit.prevent="onSubmit"></form>
				<!-- 修饰符可以串联  -->
				<a v-on:click.stop.prevent="doThat"></a>
				<!-- 只有修饰符 -->
				<form v-on:submit.prevent></form>
				<!-- 添加事件侦听器时使用事件捕获模式 -->
				<div v-on:click.capture="doThis">...</div>
				<!-- 只当事件在该元素本身（而不是子元素）触发时触发回调 -->
				<div v-on:click.self="doThat">...</div>

				<!-- click 事件只能点击一次，2.1.4版本新增 -->
				<a v-on:click.once="doThis"></a>*/


//  按键修饰符
			// 监听键盘时间是添加按键修饰符
			// .enter
			// .tab
			// .delete (捕获 "删除" 和 "退格" 键)
			// .esc
			// .space
			// .up
			// .down
			// .left
			// .right
			// .ctrl
			// .alt
			// .shift
			// .meta

			/*	<!-- 只有在 keyCode 是 13 时调用 vm.submit() -->
				<input v-on:keyup.13="submit">		
				<!-- 同上 -->
				<input v-on:keyup.enter="submit">
				<!-- 缩写语法 -->
				<input @keyup.enter="submit">*/		


//  组件   （Component）
//		扩展 HTML 元素，封装可重用的代码
//		Vue.component(tagName, options)      tagName 为组件名，options 为配置选项
//											调用：<tagName></tagName>


// 注册一个全局自定义指令 v-focus
Vue.directive('focus', {
  // 当绑定元素插入到 DOM 中。
  inserted: function (el) {
    // 聚焦元素
    el.focus()
  }
})



</script>
```

[^引用来源]:参考自菜鸟教程	“https://www.runoob.com/vue2/vue-tutorial.html”

----

#### 生命周期

![vue-notes-0000](static\pircture\vue-notes\vue-notes-0000.png)

[^引用来源]:图片来自vue官网 "https://cn.vuejs.org/v2/guide/instance.html"



| vue2.0        | description                                                  |
| ------------- | ------------------------------------------------------------ |
| beforeCreate  | 组件实例刚被创建，组件属性还未初始化                         |
| created       | 组件实例创建完成，属性绑定完成，但是DOM还没生成，$el属性还不存在 |
| beforeMount   | 模板编译挂载之前调用                                         |
| mounted       | 模板编译挂载之后调用，但不能保证组件已在document中           |
| beforeUpdate  | 组件更新之前调用                                             |
| updated       | 组件更新之后调用                                             |
| activated     | keep-alive，组件被激活时调用                                 |
| deactivated   | keep-alive，组件被移除时调用                                 |
| beforeDestroy | 组件销毁前调用                                               |
| destroyed     | 组件销毁后调用                                               |



```html
<div id="app">
        <input type="button" value="显示效果" @click="msg='no'">
        <h1 id="h1">{{msg}}</h1>
    </div>
<script src="./lib/vue-2.4.0.js"></script>
<script>
        var vm = new Vue({
            el:'#app',
            data:{
                msg:'ok',
            },
            methods:{
                show(){
                    console.log('执行了show方法');
                }
            },
            beforeCreate() {
                //第一个生命周期函数，表示实例被完全创建出来之前执行它
                this.show();
                //注意：在beforeCreate生命周期函数执行的时候，data和methods中的数据都还没有初始化,在实例初始化之后，数据观测 (data observer) 和 event/watcher 事件配置之前被调用。
            },
            created() {
                //第二个生命周期函数
                console.log(this.msg);
                this.show();
                // 在created中，data和methods都已经被初始化好了
                // 如果调用methods中的方法，或者操作data中的数据库，最早最早也只能在created中操作！在实例创建完成后被立即调用。在这一步，实例已完成以下的配置：数据观测 (data observer)，property 和方法的运算，watch/event 事件回调。然而，挂载阶段还没开始，$el property 目前尚不可用。
            },
            beforeMount(){
                // 第三个生命周期函数，表示模板已经在内存中编译完成，但是尚未把模板渲染到页面中去
                console.log(document.getElementById('h1').innerText)
                // 在beforeMount执行的时候，页面中的元素还没有被真正的替换过来，只是之前写的一些模板字符串,在挂载开始之前被调用：相关的 render 函数首次被调用。
            },
            mounted() {
                //第四个生命周期函数，表示内存中的模板，已经真实的挂载到了页面中，用户已经可以看到渲染好的页面了
                console.log(document.getElementById('h1').innerText);
                // 注意：mounted是实例创建期间的最后一个生命周期函数，当执行完mounted,就表示实例已经被完全创建好了，
                // 此时如果没有其他操作的话，这个实例就会渲染到页面,
                // 注意 mounted 不会保证所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以在 mounted 内部使用 vm.$nextTick：
                // 该钩子在服务器端渲染期间不被调用。
            },  
            // 接下来是运行中的两个事件
            beforeUpdate() {
                //第五个生命周期函数，注意：这个事件会根据data数据的改变，有选择性的触发0次或多次
                //这时候表示：我们的界面还没有被更新(数据已经被更新了)
                console.log('界面上元素内容：' + document.getElementById('h1').innerText);
                console.log('data中的msg数据是：' + this.msg);
                //当执行beforeUpdate的时候，页面中的显示的数据还是旧的，此时data数据是最新的,页面和最新的数据尚未保持同步
                //该钩子在服务器端渲染期间不被调用，因为只有初次渲染会在服务端进行。
            },
            updated(){
                //第六个生命周期函数，注意：这个事件会根据data数据的改变，有选择性的触发0次或多次
                console.log('界面上元素内容：' + document.getElementById('h1').innerText);
                console.log('data中的msg数据是：' + this.msg);
                //updated事件执行的时候，页面和data数据已经保持同步了，都是最新的
                //注意 updated 不会保证所有的子组件也都一起被重绘。如果你希望等到整个视图都重绘完毕，可以在 updated 里使用 vm.$nextTick：
            },
            beforeDestroy() {
                //第七个生命周期函数，
                //当执行beforeDestroy勾子函数的时候，Vue实例已经从运行阶段进入到销毁阶段
                //当执行beforeDestroy勾子函数的时候，实例身上所有的data和所有的methods，以及过滤器.指令。。。
                //都处于可用状态，此时，还没有真正的执行销毁过程
            },
            destroyed() {
                //第八个生命周期函数，
                //当执行到destroyed函数的时候，组件已经被完全销毁了，此时，组件中所有的数据.方法.指令.过滤器。。。
                //都已经不可用了
            },
            activated() {
            	//被 keep-alive 缓存的组件激活时调用。
            	//该钩子在服务器端渲染期间不被调用。
            }，
            deactivated() {
            //被 keep-alive 缓存的组件停用时调用。
            //该钩子在服务器端渲染期间不被调用。
            }，
        });
        
    </script>

```

[^引用来源]:代码块内部分来自 "https://blog.csdn.net/finally_leave/article/details/107338926"







## 相关实例



### 自定义指令：

#### 实现一键copy

---

**首先建一个 js 文件（v-copy.js）。定义一个对象。（ 指令实际就是一个对象 ）**

```js
import { Message } from 'ant-design-vue'

const vCopy = { // 名称使用时为 v-copy, 注册到全局指令中见 directives.js
  /**
   * 一键复制指令
   *
   * bind 钩子函数，第一次绑定时调用，可以在这里做初始化设置
   * el: 作用的 dom 对象
   * value: 传给指令的值，也就是我们要 copy 的值
   */
  bind (el, { value }) {
    el.$value = value // 用一个全局属性来存传进来的值，因为这个值在别的钩子函数里还会用到
    el.handler = () => {
      if (!el.$value) {
        // 值为空的时候，给出提示，这里的提示是用的 ant-design-vue 的提示
        Message.warning('无复制内容')
        return
      }
      // 动态创建 textarea 标签
      const textarea = document.createElement('textarea')
      // 将该 textarea 设为 readonly 防止 iOS 下自动唤起键盘，同时将 textarea 移出可视区域
      textarea.readOnly = 'readonly'
      textarea.style.position = 'absolute'
      textarea.style.left = '-9999px'
      // 将要 copy 的值赋给 textarea 标签的 value 属性
      textarea.value = el.$value
      // 将 textarea 插入到 body 中
      document.body.appendChild(textarea)
      // 选中值并复制
      textarea.select()
      textarea.setSelectionRange(0, textarea.value.length)
      const result = document.execCommand('Copy')
      if (result) {
        Message.success('复制成功')
      }
      document.body.removeChild(textarea)
    }
    // 绑定点击事件，就是所谓的一键 copy
    el.addEventListener('click', el.handler)
  },
  // 当传进来的值更新的时候触发
  componentUpdated (el, { value }) {
    el.$value = value
  },
  // 指令与元素解绑的时候，移除事件绑定
  unbind (el) {
    el.removeEventListener('click', el.handler)
  }
}
export default vCopy
```

**一键 Copy 的功能就基本实现了。然后可以将自定义指令注册到全局：再新建一个 js （ directives.js ）文件来注册所有的全局指令。**

```js
import copy from './v-copy'
// 自定义指令
const directives = {
  copy
}
// 这种写法可以批量注册指令   (将自定义指令注册到全局)，之后需要在main.js 中进行引入
export default {
  install (Vue) {
    Object.keys(directives).forEach((key) => {
      Vue.directive(key, directives[key])
    })
  }
}
```

**最后，在 main.js 中引入**

```vue
import Vue from 'vue';
import Directives from './directives';
Vue.use(Directives);
```

**用法如下**

```vue
<template>
 <button v-copy="copyText">copy</button>
</template>
<script>
export default {
 data() {
 return {
 copyText: '要 Copy 的内容',
 };
 },
};
</script>
```

[^引用来源]:  前端小学生   "https://zhuanlan.zhihu.com/p/82864047"



