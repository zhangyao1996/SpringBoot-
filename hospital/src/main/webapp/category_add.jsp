<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8">
        <title>新建</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/hospital/category/list.do">
                        慕课网科室分类管理
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${username}!</h1>
                <p>请小心的新增科室分类，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>新建</small></h3>
            </div>
            <form class="form-horizontal" action="/hospital/category/add.do" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称 ：</label>
                    <div class="col-sm-8">
                        <input name="name" class="form-control" id="name">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
          
                    </div>
                   
                </div>
                 <div class="form-group">
                 <div class="col-sm-offset-2 col-sm-10">
                    
                    <a href="javascript:history.go(-1);" class="btn btn-primary">返回</a>
                    </div>
                    </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
    </body>
</html>
