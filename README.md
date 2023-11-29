# gnomeshghOj

### 11.27

1. 查看Markdown编辑器bytemd（https://github.com/bytedance/bytemd）
2. 查看学习代码编辑器（https://github.com/microsoft/monaco-editor）、官方整合教程（https://github.com/microsoft/monaco-editor/blob/main/docs/integrate-esm.md）

### 11.28

####     创建题目页面

1. 使用表单组件，先复制代码，再修改：https://arco.design/vue/component/form
2. 嵌套表单：https://arco.design/vue/component/form#nest
3. 动态增减表单：https://arco.design/vue/component/form#dynamic

自定义的代码编辑器组件不会被组件库识别，需要手动指定value和handleChange函数

### 11.29

   题目管理页面开发

1. 使用表格组件（https://arco.design/vue/component/table#custom）需要找到自定义的示例
2. 查询数据
3. 定义表格列
4. 加载数据
5. 调整格式

   比如json格式不好看，有两种方法调整：

​      1）使用组件库自带的语法，自动格式化（更方便）

​       2）完全自定义渲染，想展示什么就展示什么（更灵活）

​    6.添加删除、更新操作

​    删除要执行的loadData刷新数据

  

​    更新页面开发

​      策略：由于更新和创建都是相同的表单，完全没必要开发/复制2遍，直接可以复制创建页面

​      关键实现：如何区分两个页面？

​         1.路由（/add/question和/update/question）

​         2.请求参数（id=1）



​      更新页面相比于创建页面，多了2个改动：

​         1）在加载页面时，更新页面需要加载出之前的数据

​         2）在提交时，请求的地址不同
